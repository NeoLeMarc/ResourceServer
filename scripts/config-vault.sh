#!/bin/bash
set -e
case $1 in
    dev)
        export VAULT_ADDR='http://127.0.0.1:8200'
        vault login $VAULT_TOKEN
        ;;
    prod)
        export VAULT_ADDR='http://127.0.0.1:8200'
        vault login $VAULT_TOKEN
        ;;
esac

echo "Enter mySQL password"
read -s MYSQLPW

vault kv put secret/resourceserver mariadb.username=resourceserver
vault kv put secret/resourceserver mariadb.password=$MYSQLPW
