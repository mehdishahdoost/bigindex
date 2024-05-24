### Install K3D

```
brew install k3d
```

### create a cluster 

```
k3d cluster create mycluster

```
### Get nodes

```
kubectl get nodes
```

### Generates kubeconfig file

```
k3d kubeconfig merge mycluster --kubeconfig-switch-context
```

### List nodes

```
k3d node list 
```

### Check K3D version

```
k3d version 
```
