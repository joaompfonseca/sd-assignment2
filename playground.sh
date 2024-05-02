#!/bin/bash
source load_env.sh

NODE="sd$LAB$GROUP@l040101-ws$MACHINE_PLAYGROUND.ua.pt"

echo "- Playground will be deployed on $NODE"

echo "-- Transferring data to the Playground node"
sshpass -f password ssh "$NODE" "rm -rf ~/dist"
sshpass -f password scp -r dist/Playground.zip "$NODE":~

echo "-- Decompressing data sent to the Playground node"
sshpass -f password ssh "$NODE" "unzip -q ~/Playground.zip -d ~"

echo "-- Executing the Playground program"
sshpass -f password ssh "$NODE" "fuser -k $PORT_PLAYGROUND/tcp > /dev/null 2>&1"
sshpass -f password ssh "$NODE" \
  "cd ~/dist/Playground ;
  java server.main.PlaygroundServer \
  $PORT_PLAYGROUND \
  l040101-ws$MACHINE_GENERAL_REPOSITORY.ua.pt $PORT_GENERAL_REPOSITORY"
