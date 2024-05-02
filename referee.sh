#!/bin/bash
source load_env.sh

NODE="sd$LAB$GROUP@l040101-ws$MACHINE_REFEREE.ua.pt"

echo "- Referee will be deployed on $NODE"

echo "-- Transferring data to the Referee node"
sshpass -f password ssh "$NODE" "rm -rf ~/dist"
sshpass -f password scp -r dist/Referee.zip "$NODE":~

echo "-- Decompressing data sent to the Referee node"
sshpass -f password ssh "$NODE" "unzip -q ~/Referee.zip -d ~"

echo "-- Executing the Referee program"
sshpass -f password ssh "$NODE" \
  "cd ~/dist/Referee ;
  java client.main.RefereeClient \
  l040101-ws$MACHINE_PLAYGROUND.ua.pt $PORT_PLAYGROUND \
  l040101-ws$MACHINE_REFEREE_SITE.ua.pt $PORT_REFEREE_SITE"
