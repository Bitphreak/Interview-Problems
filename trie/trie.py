
class TrieNode(dict) :

    def __init__(self, *args, **kw):
        super(Node,self).__init__(*args, **kw)
        self.itemlist = super(odict,self).keys()

    def __init__(self) :
        self.word = None;
        self.nodes = {}

    def insert_word(self, word) :
        self.insert_prefix(word, 0)
        
    def insert_prefix(self, word, index) :
        end_index = len(word) - 1
        if index <= end_index :
            char = word[index]
            if not char in current :
                self[char] = Node()
            current = current[char]

            if i == end_index :
                current.word = word

    #def __iter__(self):
    #def __next__(self):


# class Trie(object) :


#     head = Node()
#     self.current = head

#     def __setitem__(self, key, value):
#     # TODO: what should happen to the order if
#     #       the key is already in the dict       
#     self.itemlist.append(key)
#     super(odict,self).__setitem__(key, value)
#     def __iter__(self):
#     return iter(self.itemlist)
#     def keys(self):
#     return self.itemlist
#     def values(self):
#     return [self[key] for key in self]  
#     def itervalues(self):
#     return (self[key] for key in self)



#     def __init__(self, words=None) :
#         self.head = Node()
#         self.current = head

#         if words is not None :
#             for word in words :
#                 self.insert_word(word)


#     def walk_trie(self) :
#         for key in head :
#             node = head[key]
#     # def __iter__(self):
#     #     self.current = head
#     #     return self

#     # def __next__(self):
#     #     if self.current > self.high:
#     #         raise StopIteration
#     #     else:
#     #         self.current += 1
#     #         return self.current - 1


if __name__ == '__main__':

    with open('/usr/share/dict/words') as f :
        words = f.read().splitlines()

    trie = TrieNode()

    for i, word in enumerate(words) :
        trie[word] = word
        if i == 9 :
            break

    print trie

    # trie = Trie(words)

