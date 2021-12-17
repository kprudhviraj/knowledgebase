# Dynamo DB
* Fully Managed Service (managed ) 
* NoSQL
* Schema Less
* Provisioned throughput refers to the level of read and write capacity that you want AWS to reserve for your table.

| Amazon DynamoDB | RDBMS |
| ----------- | ----------- |
| Quries via API Calls| Quries written in SQL |
| Flexible Column Schema   | Fixed schema for each table |
| "infinitly" scalable | Difficult to scale beyond 1 hour|
| Eventually consistent | ACID compliant|

| Amazon DynamoDB | MongoDB,CASSANDRA,Couchbase |
| ----------- | ----------- |
| Document Store | Key-value store,Document Store,Column family store|
| Eventually Consistent | Eventually Consistent,Immediatley Consistent|
| Transparently Scalable | Add Servers to scale cluster|
| Managed by AWS | Self-managed and Self-Hosted |

## DynamoDB API

| Managing Tables | Remarks | 
|---------------|-------------|
|ListTables | 
|DescribeTable|
|CreateTable| **Table Name**: Ex: Orders ,**Primary Key**: Order Id,** Sort Key: Order_Line_Num **, **Read & Write Capacity Units** |
|Updatetable|
|DeleteTable|

| Reading Data |
|---------------|
|GetItem |
|BatchGetItem|
|Query|
|Scan|

| Managing Tables |
|---------------|
|PutItem |
|UpdateItem|
|DeleteItem|
|BatchWriteItem|



## Drawbacks
* Your data is automatically replicated.Three copies are stored in three different availability zones.in milliseconds, but sometimes it can take longer. This is known as eventual consistency But there are certain kinds of queries and table scans that may return older versions of data before the most recent copy.
* DynamoDB's queries aren't as flexible like Sql `Computation in your application code`
* DynamoDB doesn't offer the wide range of data types
* maximum record size of 400 KB and the limit of 10 indexes per table
* DynamoDB performance can scale up as your needs grow, your performance is limited to the amount of read and write throughput that you've provisioned for each table. If you expect a spike in database use, you will need to provision more throughput in advance or database requests will fail with a ProvisionedThroughputExceededException.
