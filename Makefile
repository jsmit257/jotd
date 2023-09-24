.PHONY: initdb
initdb:
	./bin/initdb

.PHONY: build
build:
	javac -Xlint:deprecation -cp "com/:lib/json-20230618.jar:lib/sqlite-jdbc-3.43.0.0.jar:lib/postgresql-42.6.0.jar:lib/javaee-api-8.0.jar:lib/slf4j-api-2.0.7.jar" `find . -name '*.java'`

.PHONY: unit
unit: build

.PHONY: package
package: build
	jar cf lib/jotd.jar `find com -name '*.class'` jotd*.properties

.PHONY: run-local
run-local: package initdb
	java -cp lib/jotd.jar:lib/javaee-api-8.0.jar:lib/json-20230618.jar:lib/slf4j-api-2.0.7.jar:lib/slf4j-simple-2.0.7.jar:lib/sqlite-jdbc-3.43.0.0.jar com.jotd.cmd.JOTD

.PHONY: deploy
deploy:

.PHONY: run-docker
run-docker:

