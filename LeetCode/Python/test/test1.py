if None:
    print("none")

if not None:
    print("not none")


class A:
    a_class_val = 1

    def __init__(self, a_num_val):
        self.a_num_val = a_num_val
        self.a_class_val = a_num_val


def func(self):
    """

    :param self:
    """
    print("func")


a = A(2)

a1 = A(3)

print(a.a_class_val)
print(a1.a_class_val)

print(a.a_num_val)
print(a1.a_num_val)
