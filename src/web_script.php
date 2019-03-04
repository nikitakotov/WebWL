<?php

// It's an example, if u join to server with this code, only with nickname "nkotof" u can join.

$api = $_REQUEST;

$accepted_names = array(
    "nkotof"
);

if(isset($api['name']) and strlen($api['name'] <= 16) and strlen($api['name']) >= 5) {
    if(isset($api['wmuser']) and strlen($api['wmuser']) == 32 and $api['wmuser'] == md5(md5($api['name']))) {
        if(isset($api['key']) and $api['key'] == md5($api['name'].$api['wmuser'])) {
            if(isset($api['random'])) {
                if(in_array($api['name'], $accepted_names)) {

                    // more checks if u need. also u can use ur parameters (setup in plugin config.yml)

                    die("ok");

                } else { die("whitelist_error"); }
            } else { die("random_error"); }
        } else { die("key_error"); }
    } else { die("crypt_error"); }
} else { die("name_error"); }