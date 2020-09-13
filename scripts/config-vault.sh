#!/usr/bin/zsh
case $1 in
    dev)
        echo "running in dev environment"
        export VAULT_ADDR='http://127.0.0.1:8200'
        vault login $VAULT_TOKEN
        ;;
    prod)
        echo "running in prod environment"
        unset VAULT_TOKEN
        eval `gpg -d ~/dokumente/secret/passwords/scripts/kubemaster01_login.sh.gpg`
        #export VAULT_ADDR='https://127.0.0.1:8200'
        #vault login $VAULT_TOKEN
        ;;
    *)
        echo "unkown environment $1"
        ;;
esac

echo "Enter mySQL password"
read -s MYSQLPW


vault kv put secret/resourceserver spring.datasource.username=resourceserver spring.datasource.password=$MYSQLPW spring.datasource.url=jdbc:mariadb://mysql01.kubernetes.ka.xcore.net:3306/resourceserver cassandra.contactpoints=cassandra01.kubernetes.ka.xcore.net cassandra.keyspace=resourceserver cassandra.localdatacenter=datacenter1
