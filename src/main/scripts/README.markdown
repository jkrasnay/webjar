# Utility Scripts

The `webjar` script is a Unix shell script that runs a webjar (or any
executable Java jar) as a Unix daemon. 

To use this script:

1. Copy the script under `/etc/init.d` and rename it to match the name
of your application.

2. Review the variables at the top of the script and set them
appropriately.

3. Integrate the script with your /etc/rc*.d scripts (OK, this could be
better. There are shortcuts depending on your distro. I'll put something
more here later.)

`sudo /etc/init.d/myapp start` starts the application as a daemon. It
will refuse to run if the app is already running.

`sudo /etc/init.d/myapp stop` stops the application if it's running.

`sudo /etc/init.d/myapp threaddump` dumps the stack trace of all threads
in the VM to `/var/log/myapp-stdout.log`.

## Notes on Logging

By default, the `webjar` wrapper script sends all stdout and stderr
output to `/var/lib/myapp-stdout.log`. I suggest you configure your
logging toolkit (log4j or whatever) to log somewhere else (using
DailyRollingFileAppender or SyslogAppender) and reserve the stdout file
for thread dumps. The reason is it's tricky to rotate the stdout file,
e.g. you must use the `copytruncate` with `logrotate`, which opens the
possibility of lost log messages.

