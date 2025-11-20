"""display alternate characters from a line of text using recursion"""
def display_alternate_characters(text, index=0):
    if index >= len(text):
        return ""
    else:
        return text[index] + display_alternate_characters(text, index + 2)  
# Example usage:
input_text = "Hello, this is a sample text."
result = display_alternate_characters(input_text)
print("Original text:", input_text)
print("Alternate characters:", result)  
