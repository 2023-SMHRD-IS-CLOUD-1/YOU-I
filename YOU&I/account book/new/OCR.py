import requests
import uuid
import time
import base64
import json


api_url = 'https://67n8p6j9j9.apigw.ntruss.com/custom/v1/26646/8e91acb70d873b87aabbf23331581173af5b86c1f7402b56b83e9753cf75739c/document/receipt'
secret_key = 'SlNRakxNbWZxdlhFS3pXSlRLVEhNbktJaUpCcElZV3E='
image_file = 'C:/Users/USER/Desktop/receipt.jpg'

with open(image_file,'rb') as f:
    file_data = f.read()

request_json = {
    'images': [
        {
            'format': 'jpg',
            'name': 'demo',
            'data': base64.b64encode(file_data).decode()
        }
    ],
    'requestId': str(uuid.uuid4()),
    'version': 'V2',
    'timestamp': int(round(time.time() * 1000))
}

payload = json.dumps(request_json).encode('UTF-8')
headers = {
  'X-OCR-SECRET': secret_key,
  'Content-Type': 'application/json'
}

response = requests.request("POST", api_url, headers=headers, data = payload)

print(response.text)

# In[35]:


result = response.json()
with open('result.json', 'w', encoding='utf-8') as make_file:
    json.dump(result, make_file, indent="\t", ensure_ascii=False)
    text = ""


# In[39]:


response_json = response.json()

name = response_json['images'][0]['receipt']['result']['storeInfo']['name']['text']
date = response_json['images'][0]['receipt']['result']['paymentInfo']['date']['formatted']
money = response_json['images'][0]['receipt']['result']['totalPrice']['price']['formatted']['value']
print(name,date['year'],date['month'],date['day'],money)

