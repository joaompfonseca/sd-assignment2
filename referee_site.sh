#!/bin/bash
source load_env.sh

NODE="sd$LAB$GROUP@l040101-ws$MACHINE_REFEREE_SITE.ua.pt"

echo "- Referee Site will be deployed on $NODE"

echo "-- Transferring data to the Referee Site node"
sshpass -f password ssh "$NODE" "rm -rf ~/dist/RefereeSite"
sshpass -f password scp -r dist/RefereeSite.zip "$NODE":~

echo "-- Decompressing data sent to the Referee Site node"
sshpass -f password ssh "$NODE" "unzip -q ~/RefereeSite.zip -d ~"

echo "-- Executing the Referee Site program"
sshpass -f password ssh "$NODE" "fuser -k $PORT_REFEREE_SITE/tcp > /dev/null 2>&1"
sshpass -f password ssh "$NODE" \
  "cd ~/dist/RefereeSite ;
  java server.main.RefereeSiteServer \
  $PORT_REFEREE_SITE \
  l040101-ws$MACHINE_GENERAL_REPOSITORY.ua.pt $PORT_GENERAL_REPOSITORY"
