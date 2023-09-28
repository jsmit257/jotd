## Joke Of The Day
A simple service to read and update a Joke Of The Day.  Currently runs as standalone on a workstation with `make`, `sqlite3` and any +Java6 version, or in docker using a postgres backend.

#### Requirments (standalone and docker)
- make
- sqlite3
- curll

#### Optional (docker only)
- docker
- docker-compose

### Starting

#### Standalone
Run `make run-local` to start the server; Default settings bind to localhost:8080 but can be changed in the `run-local` target in `Makefile`; This target:
- deletes any existing jotd database, unless the `NO_CLOBBER_DB` env var is non-empty
- creates the new database and seeds data
- starts the server as a local process

#### Docker
Run `fun-docker` to start the postgres service and the jotd server; Default host and port are the same as for [standalone](#standalone) and can be modified in [docker-compose](./docker-compose.yml); This target:
- stops any existing services in this [docker-compose](docker-compose.yml)
- starts a postgres service called `jotd-db`
- applies the jotd schema to the postgres instance (after a pause)
- starts the jotd server in a `jotd-api` service

### Using
`curl` is one method for accessing the service and the basis of our poor-man's system testing; `jq` could do a great job comparing outputs, except that `curl` dumps the status code to stdout in non-JSON format that makes `jq` gak; 

Some simple examples from [tests](./bin/tests) follow:
- fetch a joke for the given day
```sh
curl -i -XGET "http://localhost:8080/jotd?day=2023-09-23"
```
- create a joke
```sh
curl -i -XPOST http://localhost:8080/jotd -d '{"day":"2023-09-25","text":"not funny"}'
```
- modify a joke
```sh
curl -i -XPATCH http://localhost:8080/jotd -d '{"day": "2023-09-24", "text": "now is funny", "old-day": "2023-09-25"}'
```
- delete a joke
```sh
curl -i -XDELETE http://localhost:8080/jotd -d '{"day": "2023-09-24"}'
```

A seed value for '2023-09-23' is created in the init scripts

The general body for a request/response looks like this:
```json
{
  "id": 0, // (optional) unused
  "day": "1970-01-01", // (required) date in yyyy-MM-dd format
  "old-day": "1970-01-01", // only used for PATCH, never returned from the serverl
  "text": "the text of the joke", // (required)
  "desc": "optional description" // (optional)
}
```
Fields marked as (optional) are optional for input; All fields are returned in responses, except `desc` if it's null (empty strings are included), and `old-day` which is input-only; One notable exception is that the `id` field is the default-long value (0) for inserts, since we didn't want to go back to the db for one more `select` after `insert`; May be better just to leave this field out completely

There's also a UI available for UAT at localhost:8080/index.html.  It's not pretty to look at except that it's complete and very simple under the covers. It has push-button convenience and clearly displays the data and response

### Testing
There is unit testing in the [http package](./com/jotd/http/JokeHandlerTests.java). They only cover GET requests, but they demonstrate the pattern we'd use for all methods if this were a customer-facing app, plus we've done enough system and UAT during development that all possible code-paths should be covered. Data package was hard to unit-test because of some massive `java.sql.*` things that needed mocking/faking. There's certainly a good framework out there somewhere

As mentioned above, [tests](./bin/tests) runs at the system level and can exercise all the errors except `SQLException`; And it lacks proper automation, so a human has to review the expected v. actual results. Maybe a day and I'd have a thumbs-up/-down kind of test written in *something*

Finally, you can put on your quality assurance hat and fiddle with the web front-end. It does all the CRUD in a simple, more-or-less intuitive way

#### Testing-TODO:
- figure out how to mock `Connection`, `PreparedStatement`, etc to create unit tests for the data layer
- create a properly automated system test with clear results
l