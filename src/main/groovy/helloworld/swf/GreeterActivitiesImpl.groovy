/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.swf

class GreeterActivitiesImpl implements GreeterActivities {
  @Override
  String getName() {
    "World"
  }

  @Override
  String getGreeting(String name) {
    "Hello ${name}!"
  }

  @Override
  void say(String what) {
    println what
  }
}
