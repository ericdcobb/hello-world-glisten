/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.swf

import com.netflix.glisten.WorkflowDescriptionTemplate

class GreeterWorkflowDescriptionTemplate extends WorkflowDescriptionTemplate implements GreeterWorkflow {
  @Override
  void greet() {
    description = "Greeter will greet!"
  }
}
