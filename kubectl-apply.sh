#!/bin/bash
# Files are ordered in proper order with needed wait for the dependent custom resource definitions to get initialized.
# Usage: bash kubectl-apply.sh

logSummary(){
    echo ""
    echo "#####################################################"
    echo "Please find the below useful endpoints,"
    echo "JHipster Grafana - http://jhipster-grafana.default."
    echo "#####################################################"
}

kubectl apply -f kubernetes/auctionsniper/
kubectl apply -f kubernetes/messagebroker/
kubectl apply -f kubernetes/monitoring/jhipster-prometheus-crd.yml
until [ $(kubectl get crd prometheuses.monitoring.coreos.com 2>>/dev/null | wc -l) -ge 2 ]; do
    echo "Waiting for the custom resource prometheus operator to get initialised";
    sleep 5;
done
kubectl apply -f kubernetes/monitoring/jhipster-prometheus-cr.yml
kubectl apply -f kubernetes/monitoring/jhipster-grafana.yml
kubectl apply -f kubernetes/monitoring/jhipster-grafana-dashboard.yml

logSummary
