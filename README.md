# WebWL beta

[![N|Solid](https://pp.userapi.com/c847219/v847219431/1bdaf3/tR9awx73nsI.jpg)](https://github.com/nikitakotov)

## Releases
- [x] Get requests
- [x] Checking player
- [x] Requests to localhost webserver
- [ ] Post requests
- [ ] Transport from JAVA to KOTLIN  


#### Web script example with default requests
```php
<?php
$api = $_REQUEST;
$accepted_names = array(
    "nkotof"
);
if(isset($api['name']) and strlen($api['name'] <= 16) and strlen($api['name']) >= 5) {
    if(isset($api['wmuser']) and strlen($api['wmuser']) == 32 and $api['wmuser'] == md5(md5($api['name']))) {
        if(isset($api['key']) and $api['key'] == md5($api['name'].$api['wmuser'])) {
            if(isset($api['random'])) {
                if(in_array($api['name'], $accepted_names)) {
                    die("ok");
                } else { die("whitelist_error"); }
            } else { die("random_error"); }
        } else { die("key_error"); }
    } else { die("crypt_error"); }
} else { die("name_error"); }
```

#### Configuration
*Edit config.yml*
```yml
request:
  url: 'http://localhost/api.php'
  more-params: '&someparameter=test'
  response: 'ok'
```

> Url can move to local web-server.


