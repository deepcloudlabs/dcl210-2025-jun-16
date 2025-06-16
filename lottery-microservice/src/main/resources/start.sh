#!/bin/bash
$1 &
export PID=$!
while [ "$(curl -s -o /dev/null -L -w ''%{http_code}'' http://localhost:$2/$3)" != "200" ];
        do sleep 0.001;
done
ps -p $PID -o rss,cputime
kill -9 $PID