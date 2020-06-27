for /f %e in ('docker ps -q') do docker stop %e
for /f %e in ('docker ps -a -q') do docker rm %e