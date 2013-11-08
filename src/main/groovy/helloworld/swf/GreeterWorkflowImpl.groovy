/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.swf

import com.amazonaws.services.simpleworkflow.flow.core.Promise
import com.netflix.glisten.SwfWorkflowOperations
import com.netflix.glisten.WorkflowOperations

class GreeterWorkflowImpl implements GreeterWorkflow {

  @Delegate
  WorkflowOperations<GreeterActivities> operations = SwfWorkflowOperations.of(GreeterActivities)

  @Override
  void greet() {
    doTry {
      Promise<String> name = promiseFor(activities.getName())
      waitFor(name) {
        Promise<String> greeting = promiseFor(activities.getGreeting(name.get()))
        waitFor(greeting) {
          waitFor(activities.say(greeting.get())) { status.it }
        }
      }
    } withCatch { Throwable t ->
      status t.message
    }
  }
}
