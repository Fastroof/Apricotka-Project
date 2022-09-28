minikube start
minikube addons enable ingress
eval $(minikube -p minikube docker-env)
export MINIKUBE_IP=$(minikube ip)
docker build -t serviceg-migrations:05 -f serviceg/migrations/Dockerfile .
docker build -t apricotka:01 -f Apricotka/Dockerfile Apricotka/
docker build -t apricotkacash:02 -f ApricotkaCash/Dockerfile ApricotkaCash/
docker build -t serviceg:03 -f serviceG/Dockerfile serviceG/
docker build -t servicei:04 -f serviceI/Dockerfile serviceI/
kubectl apply -f k8s/postgres
envsubst < k8s/Apricotka/deployment.yaml | kubectl apply -f -
kubectl apply -f k8s/Apricotka/ingress.yaml
kubectl apply -f k8s/Apricotka/service.yaml
kubectl apply -f k8s/ApricotkaCash
kubectl apply -f k8s/serviceG
kubectl apply -f k8s/serviceI
minikube tunnel