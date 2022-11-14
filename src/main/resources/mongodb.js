db.createUser({
    user: "musicapp",
    pwd:  "password",   // or cleartext password
    roles: [ { role: "readWrite", db: "musicapp" }]
});

db = new Mongo().getDB("musicapp");

db.createCollection('wish');

db.wish.insertOne({
    title: "test",
    description: "test description",
    category: "test",
    tags: ["test", "deleteme"]
});