>UFW, or Uncomplicated Firewall, is a simplified firewall management interface that hides the complexity of lower-level packet filtering technologies such as iptables and nftables.

### Check Firewall status

```
sudo ufw status
```

### Disable it

```
sudo ufw disable
```

### Enable it

```
sudo ufw enable
```

### Reset all firewall rules

```
sudo ufw reset
```

### Check all Firewall rules directly with iptables

```
sudo iptables -L
```

### 

```
sudo ufw default deny incoming
sudo ufw default allow outgoing

sudo ufw allow ssh

sudo ufw allow 22

sudo ufw enable

sudo ufw allow 6000:6007/tcp
sudo ufw allow 6000:6007/udp

sudo ufw allow from 203.0.113.4

sudo ufw allow from 203.0.113.4 to any port 22

sudo ufw deny from 203.0.113.4

sudo ufw deny http

sudo ufw delete allow http

sudo ufw disable

sudo ufw reset
```
