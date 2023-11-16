#!/bin/bash

# Static username and password
USERNAME="johndoe"
PASSWORD="password"

# Define the OIDC token endpoint, client ID, and client secret
TOKEN_ENDPOINT="http://localhost:9900/realms/blueprint/protocol/openid-connect/token"
CLIENT_ID="blueprint-app"
CLIENT_SECRET="uytjaSsUP2iwSepYH3fXGlQWnHHnNoLU"

# Make the request
RESPONSE=$(curl -s -X POST $TOKEN_ENDPOINT \
    -d "grant_type=password" \
    -d "username=$USERNAME" \
    -d "password=$PASSWORD" \
    -d "client_id=$CLIENT_ID" \
    -d "client_secret=$CLIENT_SECRET")

# Extract and display the token
TOKEN=$(echo $RESPONSE | jq -r '.access_token')
#echo "Access Token: $TOKEN"

# Copy token to clipboard
case "$(uname -s)" in
    Linux*)     echo $TOKEN | xclip -selection clipboard ;;
    Darwin*)    echo $TOKEN | pbcopy ;;
    CYGWIN*|MINGW32*|MSYS*|MINGW*) echo $TOKEN | clip ;;
    *)          echo "Clipboard not supported for this OS" ;;
esac