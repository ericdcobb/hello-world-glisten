/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.pogo

class GreeterMain {

  static void main(String [] args) {
    GreeterWorkflow greeter = new GreeterWorkflowImpl()
    greeter.greet()
  }
}
