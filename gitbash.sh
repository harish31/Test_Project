#!/bin/bash
git add .
echo "Enter Commit message"
read commit_msg
git commit -m "$commit_msg"
git push -u origin master
