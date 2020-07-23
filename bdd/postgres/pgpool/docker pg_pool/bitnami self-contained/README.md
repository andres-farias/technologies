# Self-contained PG-POOL II POC

This configuration will use a [Docker Compose](https://docs.docker.com/compose/) configuration file that is
 structured to deploy 2 Postgresql databases with an initially empty database that its replicated, the PG-POOL II
  service and an SQL client to try the configured system. 
  
## General configuration

The docker specification will start by declaring a general network for the common use of every service declared:
```yaml
networks:
  my-network:
    driver: bridge
```

### Services

There are four services defined: 2 database backends, a PG POOL II server, and an SQL client.

#### Backend databases

There are two backend databases defined for this configuration:
```yaml
 pg-0:
    image: bitnami/postgresql-repmgr:11
    ports:
      - 5432
    volumes:
      - pg_0_data:/bitnami/postgresql
    environment:
      - POSTGRESQL_POSTGRES_PASSWORD=adminpassword
      - POSTGRESQL_USERNAME=customuser
      - POSTGRESQL_PASSWORD=custompassword
      - POSTGRESQL_DATABASE=customdatabase
      - REPMGR_PASSWORD=repmgrpassword
      - REPMGR_PRIMARY_HOST=pg-0
      - REPMGR_PARTNER_NODES=pg-0,pg-1
      - REPMGR_NODE_NAME=pg-0
      - REPMGR_NODE_NETWORK_NAME=pg-0
  pg-1:
    image: bitnami/postgresql-repmgr:11
    ports:
      - 5432
    volumes:
      - pg_1_data:/bitnami/postgresql
    environment:
      - POSTGRESQL_POSTGRES_PASSWORD=adminpassword
      - POSTGRESQL_USERNAME=customuser
      - POSTGRESQL_PASSWORD=custompassword
      - POSTGRESQL_DATABASE=customdatabase
      - REPMGR_PASSWORD=repmgrpassword
      - REPMGR_PRIMARY_HOST=pg-0
      - REPMGR_PARTNER_NODES=pg-0,pg-1
      - REPMGR_NODE_NAME=pg-1
      - REPMGR_NODE_NETWORK_NAME=pg-1
```

#### PG-POOL II server

The PG-POOL server is declared as it follows:

```yaml
  pgpool:
    image: bitnami/pgpool:4
    ports:
      - 5432:5432
    environment:
      - PGPOOL_BACKEND_NODES=0:pg-0:5432,1:pg-1:5432
      - PGPOOL_SR_CHECK_USER=customuser
      - PGPOOL_SR_CHECK_PASSWORD=custompassword
      - PGPOOL_ENABLE_LDAP=no
      - PGPOOL_POSTGRES_USERNAME=postgres
      - PGPOOL_POSTGRES_PASSWORD=adminpassword
      - PGPOOL_ADMIN_USERNAME=admin
      - PGPOOL_ADMIN_PASSWORD=adminpassword
```

Finally, an optional SQL client is included in order to easier the test process:
```yaml
 adminer:
    image: adminer
    restart: always
    ports:
      - 9200:8080 
```