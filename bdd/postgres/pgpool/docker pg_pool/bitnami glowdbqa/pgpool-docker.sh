#! /bin/sh
docker run --detach --rm --name pg-pool \
  --env PGPOOL_BACKEND_NODES=0:glowdbqa.dev.corp.globant.com:5432,1:nglb951dxu07.tx.corp.globant.com:5432 \
  --env PGPOOL_SR_CHECK_USER=glow_bc \
  --env PGPOOL_SR_CHECK_PASSWORD=c38KXFKG \
  --env PGPOOL_ENABLE_LDAP=no \
  --env PGPOOL_POSTGRES_USERNAME=glow_bc \
  --env PGPOOL_POSTGRES_PASSWORD=c38KXFKG \
  --env PGPOOL_ADMIN_USERNAME=admin \
  --env PGPOOL_ADMIN_PASSWORD=adminpassword \
  --env PGPOOL_USER_CONF_FILE=/config/myconf.conf \
  --env PGPOOL_PASSWD_FILE=/config/pool_passwd \
  --volume pgpool-ext.conf:/config/myconf.conf \
  --volume pgpasswd:/config/pool_passwd \
  bitnami/pgpool:latest