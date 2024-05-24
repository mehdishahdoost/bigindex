### Enable Profiler in Intellij Idea [Ubuntu]

>create file /etc/sysctl.d/99-async-profiler.conf with the content:

```
kernel.perf_event_paranoid=-1
kernel.kptr_restrict=0
```
