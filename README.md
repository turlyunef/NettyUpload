# Upload Server Task
Implement an upload server for files of a size of hundreds of megabytes and even more. The
server must be implemented in Java and support multiple parallel uploads. Uploading is
done over HTTP POST. The server must be implemented in Google’s Netty framework and
Java SE 8 or greater. The upload schema to be designed to handle uploads in a next way:

# Endpoint 1. Get one-time upload link request

It’s a GET request with single parameter md5sum which returns upload POST URL in the
form of http://ip:uploadport/upload/one-time-hash
where,

● one-time-hash is a unique hash which is invalidated after one-time upload

● uploadport is port where Netty POST server listens

So, finally, e.g.

GET http://127.0.0.1:8080/getUploadUrl?md5sum=68b329da9893e34099c7d8ad5cb9c940

Response (json):
{
	‘url’: http://127.0.0.1:8081/upload/68b329da9893e34099c7d8ad5cb9c940
}

# Endpoint 2. Upload the file to the server

The endpoint allows a user to upload the file to the server.

POST: file -> http://127.0.0.1:8081/upload/68b329da9893e34099c7d8ad5cb9c940

Response (json):
{
	‘status’: OK
}
The file is saved with an arbitrary generated name in the form of UUID.
The post must track errors of next cases:
connection break
md5sum of file differ from md5sum specified in the getUploadUrl
In both cases, it must remove the file from the server.
Upon upload complete, the one-time upload URL is no longer valid for uploading but can be
used 1 hour more to get status of the upload.

# Endpoint 3. Progress meter

The special endpoint which displays the progress in bytes. It uses one-time upload hash to
get the status
GET http://127.0.0.1:8080/progress/68b329da9893e34099c7d8ad5cb9c940

Response (json):
{
	‘size’: 1234567788,
	‘status’: ‘progress|done|error-upload|error-md5’
}

# Delivery guidelines

1. Use proper RESTful specification and proper response codes.
2. Implement proper logging with SLF4J with log levels WARN, INFO, DEBUG, TRACE.
3. Use Maven or Gradle for code build.
4. Use Docker for application delivery and configuration. Build Docker image with
Maven plugin or Gradle plugin.
5. Use Netty for implementation.
6. Use Google Guava for an in-memory cache.
7. The system must use as fewer threads as possible. Don’t use Netty threads to
handle the upload work, delegate that works to separate threads. Use java executor
services.