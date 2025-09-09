#!/bin/bash
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" \
    -d '{"id": 3, "name": "new-shit", "cost": 96}'
