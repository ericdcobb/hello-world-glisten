/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.pogo

class GreeterWorkflowImpl implements GreeterWorkflow {

  GreeterActivities operations = new GreeterActivitiesImpl()

  @Override
  void greet() {
    String name = operations.name
    String greeting = operations.getGreeting(name)
    operations.say(greeting)
  }
}
