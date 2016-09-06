
class Trie(object) :

    head = {}

    def __init__(self, words=None) :
        if words is not None :
            for word in words :
                self.insert_word(word)

            print self.head

    def insert_word(self, word) :
        current = self.head
        for i, char in word :
            if not char in current :
                current[char] = {}
            current = current[char]


if __name__ == '__main__':

    with open('/usr/share/dict/words') as f :
        words = f.read().splitlines()

    trie = Trie(words)

