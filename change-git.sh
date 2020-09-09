git remote remove origin
git remote add origin ssh://git@10.10.2.18:7999/fin/resourceserver.git
git pull origin master
git branch --set-upstream-to=origin/master

git remote remove github
git remote add github git@github.com:NeoLeMarc/ResourceServer.git
git pull github master
git branch --set-upstream-to=github/master
git branch --set-upstream-to=origin/master
