#!/bin/bash
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" \
    -d '{"name": "some-shit", "cost": 96}'
