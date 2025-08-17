# TechChallenge

## Como executar a aplicação no Kubernetes

Siga os comandos abaixo para subir a aplicação no cluster Kubernetes:

```bash
kubectl apply -f k8s/techchallenge-namespace.yaml   # Cria o namespace (necessário)
kubectl apply -f k8s/                               # Aplica configurações gerais (configs e secrets)
kubectl apply -f k8s/hpas                           # Aplica o HPA
kubectl apply -f k8s/services                       # Aplica os Services
kubectl apply -f k8s/deployments                    # Aplica os Deployments (do mysql e aplicação)

********************

Se estiver rodando o Kubernetes localmente (por exemplo, via Docker Desktop),
será necessário fazer um port-forward para acessar via localhost:

kubectl port-forward svc/techchallenge-service 8080:80 -n techchallenge
```
Link para acessar o swagger:

```bash
http://localhost:8080/swagger-ui.html
```

Desenho da arquitetura Kubernetes
![Desenho Arquitetura K8s](docs/Arquitetura_k8s.png)