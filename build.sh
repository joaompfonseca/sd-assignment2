#!/bin/bash

echo "- Compiling the source code"
javac -source 1.8 -target 1.8 -Xlint:-options -d bin */*.java */*/*.java */*/*/*.java

echo "- Distributing intermediate code to the different execution environments"
rm -rf dist
mkdir -p dist

echo "-- Coach"
mkdir -p dist/Coach/client/entities \
         dist/Coach/client/main \
         dist/Coach/client/stubs/contestantsbench \
         dist/Coach/client/stubs/playground \
         dist/Coach/client/stubs/refereesite \
         dist/Coach/communication/message \
         dist/Coach/configuration
cp bin/client/entities/TCoach.class \
   dist/Coach/client/entities
cp bin/client/main/CoachClient.class \
   dist/Coach/client/main
cp bin/client/stubs/contestantsbench/*.class \
   dist/Coach/client/stubs/contestantsbench
cp bin/client/stubs/playground/*.class \
   dist/Coach/client/stubs/playground
cp bin/client/stubs/refereesite/*.class \
   dist/Coach/client/stubs/refereesite
cp bin/communication/message/Message.class \
   bin/communication/message/MessageCoach*.class \
   dist/Coach/communication/message
cp bin/communication/ClientCom.class \
   dist/Coach/communication
cp bin/configuration/Config.class \
   dist/Coach/configuration

echo "-- Contestant"
mkdir -p dist/Contestant/client/entities \
         dist/Contestant/client/main \
         dist/Contestant/client/stubs/contestantsbench \
         dist/Contestant/client/stubs/playground \
         dist/Contestant/communication/message \
         dist/Contestant/configuration
cp bin/client/entities/TContestant.class \
   dist/Contestant/client/entities
cp bin/client/main/ContestantClient.class \
   dist/Contestant/client/main
cp bin/client/stubs/contestantsbench/*.class \
   dist/Contestant/client/stubs/contestantsbench
cp bin/client/stubs/playground/*.class \
   dist/Contestant/client/stubs/playground
cp bin/communication/message/Message.class \
   bin/communication/message/MessageContestant*.class \
   dist/Contestant/communication/message
cp bin/communication/ClientCom.class \
   dist/Contestant/communication
cp bin/configuration/Config.class \
   dist/Contestant/configuration

echo "-- Referee"
mkdir -p dist/Referee/client/entities \
         dist/Referee/client/main \
         dist/Referee/client/stubs/playground \
         dist/Referee/client/stubs/refereesite \
         dist/Referee/communication/message \
         dist/Referee/configuration
cp bin/client/entities/TReferee.class \
   dist/Referee/client/entities
cp bin/client/main/RefereeClient.class \
   dist/Referee/client/main
cp bin/client/stubs/playground/*.class \
   dist/Referee/client/stubs/playground
cp bin/client/stubs/refereesite/*.class \
   dist/Referee/client/stubs/refereesite
cp bin/communication/message/Message.class \
   bin/communication/message/MessageReferee*.class \
   dist/Referee/communication/message
cp bin/communication/ClientCom.class \
   dist/Referee/communication
cp bin/configuration/Config.class \
   dist/Referee/configuration

echo "-- Contestants Bench"
mkdir -p dist/ContestantsBench/client/stubs/generalrepository \
         dist/ContestantsBench/communication/message \
         dist/ContestantsBench/configuration \
         dist/ContestantsBench/server/entities \
         dist/ContestantsBench/server/main \
         dist/ContestantsBench/server/sharedregions
cp bin/client/stubs/generalrepository/*.class \
   dist/ContestantsBench/client/stubs/generalrepository
cp bin/communication/message/*.class \
   dist/ContestantsBench/communication/message
cp bin/communication/ClientCom.class \
   bin/communication/ServerCom.class \
   dist/ContestantsBench/communication
cp bin/configuration/Config.class \
   dist/ContestantsBench/configuration
cp bin/server/entities/ContestantsBenchClientProxy.class \
   dist/ContestantsBench/server/entities
cp bin/server/main/ContestantsBenchServer.class \
   dist/ContestantsBench/server/main
cp bin/server/sharedregions/ContestantsBench*.class \
   dist/ContestantsBench/server/sharedregions

echo "-- Playground"
mkdir -p dist/Playground/client/stubs/generalrepository \
         dist/Playground/communication/message \
         dist/Playground/configuration \
         dist/Playground/server/entities \
         dist/Playground/server/main \
         dist/Playground/server/sharedregions
cp bin/client/stubs/generalrepository/*.class \
   dist/Playground/client/stubs/generalrepository
cp bin/communication/message/*.class \
   dist/Playground/communication/message
cp bin/communication/ClientCom.class \
   bin/communication/ServerCom.class \
   dist/Playground/communication
cp bin/configuration/Config.class \
   dist/Playground/configuration
cp bin/server/entities/PlaygroundClientProxy.class \
   dist/Playground/server/entities
cp bin/server/main/PlaygroundServer.class \
   dist/Playground/server/main
cp bin/server/sharedregions/Playground*.class \
   dist/Playground/server/sharedregions

echo "-- Referee Site"
mkdir -p dist/RefereeSite/client/stubs/generalrepository \
         dist/RefereeSite/communication/message \
         dist/RefereeSite/configuration \
         dist/RefereeSite/server/entities \
         dist/RefereeSite/server/main \
         dist/RefereeSite/server/sharedregions
cp bin/client/stubs/generalrepository/*.class \
   dist/RefereeSite/client/stubs/generalrepository
cp bin/communication/message/*.class \
   dist/RefereeSite/communication/message
cp bin/communication/ClientCom.class \
   bin/communication/ServerCom.class \
   dist/RefereeSite/communication
cp bin/configuration/Config.class \
   dist/RefereeSite/configuration
cp bin/server/entities/RefereeSiteClientProxy.class \
   dist/RefereeSite/server/entities
cp bin/server/main/RefereeSiteServer.class \
   dist/RefereeSite/server/main
cp bin/server/sharedregions/RefereeSite*.class \
   dist/RefereeSite/server/sharedregions

echo "-- General Repository"
mkdir -p dist/GeneralRepository/communication/message \
         dist/GeneralRepository/configuration \
         dist/GeneralRepository/server/entities \
         dist/GeneralRepository/server/main \
         dist/GeneralRepository/server/sharedregions
cp bin/communication/message/*.class \
   dist/GeneralRepository/communication/message
cp bin/communication/ServerCom.class \
   dist/GeneralRepository/communication
cp bin/configuration/Config.class \
   dist/GeneralRepository/configuration
cp bin/server/entities/GeneralRepositoryClientProxy.class \
   dist/GeneralRepository/server/entities
cp bin/server/main/GeneralRepositoryServer.class \
   dist/GeneralRepository/server/main
cp bin/server/sharedregions/EGeneralRepository*.class \
   bin/server/sharedregions/GeneralRepository*.class \
   dist/GeneralRepository/server/sharedregions

echo "- Compressing execution environments"

echo "-- Coach"
zip -rq dist/Coach.zip dist/Coach

echo "-- Contestant"
zip -rq dist/Contestant.zip dist/Contestant

echo "-- Referee"
zip -rq dist/Referee.zip dist/Referee

echo "-- Contestants Bench"
zip -rq dist/ContestantsBench.zip dist/ContestantsBench

echo "-- Playground"
zip -rq dist/Playground.zip dist/Playground

echo "-- Referee Site"
zip -rq dist/RefereeSite.zip dist/RefereeSite

echo "-- General Repository"
zip -rq dist/GeneralRepository.zip dist/GeneralRepository