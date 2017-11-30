# Anypoint MQ Demo
This is a project that demonstrates several capabilities of Anypoint MQ. It requires the setup of an exchange and 3 queues within your organization.

<img src="https://raw.githubusercontent.com/djuang1/anypoint-mq-demo/master/assets/setup.png" width="500px">

## Application Flow
The diagram below shows the flow of the application and how it interacts with Anypoint MQ.

<img src="https://raw.githubusercontent.com/djuang1/anypoint-mq-demo/master/assets/application_flow.png" width="500px">

## Mule Project
Here are the flows contained in the project.

<img src="https://raw.githubusercontent.com/djuang1/anypoint-mq-demo/master/assets/anypoint-mq-demo.png" width="500px">

## Setup
1. Create Client App in MQ and copy down the client ID and client secret
2. Create an exchange called <b>DemoExchange</b>
3. Create 3 queues
  * <b>DemoDLQ</b>
  * <b>DemoQueue</b> - Assign <b>DemoDLQ</b> as the Dead Letter Queue for this queue.
  * <b>ErrorQueue</b> - Assign <b>DemoDLQ</b> as the Dead Letter Queue for this queue and set the 'Delivery attempts before reroute' to 1
4. Edit the <b>DemoExchange</b> and bind the <b>ErrorQueue</b> and the <b>DemoQueue</b>
5. Edit the <b>mule-app.properties</b> file in the imported Mule project in Studio and populate the properties.

```mq.client_id=
mq.client_secret=
mq.url=https://mq-us-east-1.anypoint.mulesoft.com/api/v1

mq.exchange=DemoExchange
mq.queue=DemoQueue
mq.queue_nack=ErrorQueue
mq.queue_dlq=DemoDLQ```
