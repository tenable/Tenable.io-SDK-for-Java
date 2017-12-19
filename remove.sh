git filter-branch --force --index-filter \
'git rm --cached --ignore-unmatch gradle.properties' \
--prune-empty --tag-name-filter cat -- --all
