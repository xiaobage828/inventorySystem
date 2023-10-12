local key = KEYS[1];
local inventory = redis.call('hgetall', key);
local myTable = {} ; local k = '';
for i,v in ipairs(inventory) do
   if i % 2 == 1 then
      k = v
   else
      myTable[k] = v
   end;
end;
return cjson.encode(myTable);