# smolurl!

A spring-boot url shortener called smolurl. Uses my own [uuid-gen dependency](https://github.com/sxeix/uuid-gen) to create a UUIDv5 id for each url.

MongoDB is used for storing a key-value document based on the UUIDv5 for the url storage. This ensures we never have duplicate records and query time is optimal.

This will include a frontend once I have picked which one I want to work with.
