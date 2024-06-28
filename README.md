## API for Chat Completion

This API is designed to receive a message array in a POST request and generate a response implementing a free provider.

## API Usage

```txt
Method: POST
Headers:Content-Type: application/json (required)
```

```JSON
Body:
{
  "messages": [
    { "role": "user", "content": "message 1" },
    { "role": "assistant", "content": "response 1" },
    { "role": "user", "content": "message 2" }
  ]
}
```