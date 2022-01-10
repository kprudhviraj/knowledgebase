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

<table>

<tr><td>
  
| Managing Tables |
|---------------|
|ListTables | 
|DescribeTable|
|CreateTable|
|Updatetable|
|DeleteTable|
  
</td><td>
  
| Reading Data |
|---------------|
|GetItem |
|BatchGetItem|
|Query|
|Scan|
  
</td><td>
  
| Managing Tables |
|---------------|
|PutItem |
|UpdateItem|
|DeleteItem|
|BatchWriteItem|
  
</td></tr> </table>


## Drawbacks
* Your data is automatically replicated.Three copies are stored in three different availability zones.in milliseconds, but sometimes it can take longer. This is known as eventual consistency But there are certain kinds of queries and table scans that may return older versions of data before the most recent copy.
* DynamoDB's queries aren't as flexible like Sql `Computation in your application code`
* DynamoDB doesn't offer the wide range of data types
* maximum record size of 400 KB and the limit of 25 indexes per table
* DynamoDB performance can scale up as your needs grow, your performance is limited to the amount of read and write throughput that you've provisioned for each table. If you expect a spike in database use, you will need to provision more throughput in advance or database requests will fail with a ProvisionedThroughputExceededException.

## Creating table & Indexes
* Primary Key ( Partition Key )
* Composite Key ( Partition Key and a Sort Key)
* Secondry Index 
  * Global Secondry Index
    * lets you query across the entire table to find any record that matches a particular value.
    * these global secondary indexes are just like DynamoDB tables of their own.
    * Global secondary indexes use storage space that's separate from the main table, and in fact you have to configure provision throughput for each global secondary index, just like you do for a table.
    *  You can include all attributes in the index. This is called projecting attributes into the index. 
    *  big advantage to using indexes is that DynamoDB keeps the indexes updated for you automatically. When you insert or modify data in the main table
  * Local Secondry Index
    * local secondary indexes live within each partition key and help you filter data within that partition. 
    * This means that they're not useful unless you have a compound primary key. If you don't, then there would never be more than one item with a given partition key, so there's no reason you want a local secondary index.
## Understand Provisioned Throughput
* Read Capacity Units
  1. If you have five read capacity units, then DynamoDB will let you make five requests per second. 
  2. The counter resets after every second. If your records are larger than 4 kilobytes, then you'll use one read capacity unit for every 4 kilobytes.
  3. And if you elect to use eventually consistent reads rather than strong consistency, you'll only be using half as many units. You can specify this on each query.
* Write Capacity Units
  1. you will use one unit of write capacity to store a single record in your DynamoDB table, no larger than 1 kilobyte in size every second. Just like with read capacity, if your record exceeds 1 kilobyte, you would need more than one write capacity unit in order to store it in the table.
* Requests exceeding your capacity limit will be denied with an error called a `provision throughput exceeded exception`


