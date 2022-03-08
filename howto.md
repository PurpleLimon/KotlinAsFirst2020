1. git clone https://github.com/PurpleLimon/KotlinAsFirst2020
2. cd KotlinAsFirst2020
3. git remote add upstream-my https://github.com/PurpleLimon/KotlinAsFirst2021
4. git branch backport
5. git checkout backport
6. git fetch upstream-my
7. git merge upstream-my/master
8. git checkout master
9. git merge upstream-my/master
10. git remote add upstream-theirs https://github.com/BREWYM/KotlinAsFirst2021
11. git fetch upstream-theirs
12. git merge upstream-theirs/master
---> Conflicts Solving. <---
---> Conflicts Solving.. <---
---> Conflicts Solving... <---
---> Conflicts Solving. <---
---> Conflicts Solving.. <---
---> Conflicts Solving... <---

13. git add .
14. git merge --continue
15. git remotes -v
16. git add remotes.txt
17. git commit -m 'remotes.txt added'
18. git add howto.md
19. git commit -m 'howto.md added'
20. git remote set-url origin git@github.com:PurpleLimon/KotlinAsFirst2020
21. ssh-keygen -t ed25519 -C "my_email@mail.ru"
22. eval "@(ssh-agent -s)"
23. ssh-add id_ed25519
24. Some stuff on github.com to add SSH key
25. git push origin