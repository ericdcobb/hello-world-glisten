/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.swf

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions

@Activities(version = '1.0')
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300L, defaultTaskStartToCloseTimeoutSeconds = 10L)

interface GreeterActivities {
  String getName()
  String getGreeting(String name)
  void say(String what)
}
