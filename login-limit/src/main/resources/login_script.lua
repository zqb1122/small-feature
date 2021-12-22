--获得 key
local key = KEYS[1]
--获得限制
local limit = ARGV[1]
--获得时间限制
local expire = ARGV[2]
local err = ARGV[3]
if err  then
    if redis.call('exists',key) == 0 then
        redis.call('setex',key,expire,1)
    else
        if redis.call('get',key) == limit then
           return redis.call('ttl',key)
        else
            redis.call('incr',key)
        end
    end
    return 0
end

if redis.call('exists',key) == 0 then
    return 0;
end

if redis.call('get',key) == limit then
    return redis.call('ttl',key)
end

return 0