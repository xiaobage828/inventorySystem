local key, h1, h2 = KEYS[1] , KEYS[2], KEYS[3]
local v1 , v2 = ARGV[1], ARGV[2]
redis.call('hincrby', key, h1, v1)
redis.call('hset', key, h2, v2)
local inventory = redis.call('hgetall', key)
return inventory.id

