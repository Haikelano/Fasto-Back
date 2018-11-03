#!/bin/bash
echo "# Fasto-Back" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/Haikelano/Fasto-Back.git
git push -u origin master
