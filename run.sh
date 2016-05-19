#!/bin/bash

./gradlew clean jmhJar
java -jar ./build/libs/Instanceof-vs-Try-Catch-jmh.jar