local key, h1, h2 = KEYS[1] , KEYS[2], KEYS[3]
local v1 , v2 = ARGV[1], ARGV[2]
redis.call('hincrby', key, h1, 0- tostring(v1))
redis.call('hset', key, h2, v2)
local inventory = redis.call('hgetall', key)
local myTable = {} ; local k = '';
for i,v in ipairs(inventory) do
   if i % 2 == 1 then
      k = v
   else
      myTable[k] = v
   end;
end;
return cjson.encode(myTable);