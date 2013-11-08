/*
 * Copyright Balsamiq Studios, Inc.  All rights reserved.  http://www.balsamiq.com
 *
 */

package helloworld.swf

import com.amazonaws.ClientConfiguration
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient
import com.netflix.glisten.InterfaceBasedWorkflowClient
import com.netflix.glisten.WorkflowClientFactory
import com.netflix.glisten.WorkflowDescriptionTemplate
import com.netflix.glisten.WorkflowTags

class GreeterMain {
  static void main(String[] args) {
    String credentialFileName = System.getenv("AWS_CREDENTIAL_FILE")
    String accessKey
    String secretKey

    for (String line in new File(credentialFileName).readLines()) {
      def matcher = line =~ /AWSAccessKeyId=(.+)/
      if (matcher) {
        accessKey = matcher[0][1]
      }
      matcher = line =~ /AWSSecretKey=(.+)/
      if (matcher) {
        secretKey = matcher[0][1]
      }
    }

    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey)

    ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70 * 1000)

    AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(credentials, config)

    String domain = "helloWorldExamples"

    WorkflowClientFactory clientFactory = new WorkflowClientFactory(service, domain)

    WorkflowDescriptionTemplate descriptionTemplate = new GreeterWorkflowDescriptionTemplate()

    InterfaceBasedWorkflowClient<GreeterWorkflow> client = clientFactory.getNewWorkflowClient(GreeterWorkflow, descriptionTemplate, new WorkflowTags())

    client.asWorkflow().greet()
  }
}
