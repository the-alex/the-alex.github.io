---
layout: post
title: "Indexing on Command Line Bullshit"
excerpt: "Thoughts on making your own searchable archive of command-line
arcana."
share: false
modified: 2017-03-23
tags: []
---

During our lectures, students may be tempted to tune out during lecture. The
homework is relatively self-contained -- you can Google for the answer most of
the time (in fact, we are banking on that in some instances), lectures are
recorded -- but in my opinion, you aren't really able to get the command
repletion from lecture alone.  You've got to make sure that you'll actually
remember the commands and processes we talked about from lecture. You should
probably be taking notes.

But this is C4CS -- we teach command line bullshit. Most of the time, you don't
really want to memorize the commands, you want to know how to get the
information you care about as quickly as possible. Enter,
`command-line-bullshit.txt`, your personal, searchable archive of command line
arcana.

```
~/ $ cat ~/command-line-bullshit.txt
# grep :: Used for matching regular expressions to files.
grep <flags> <regular expression> <filename>

# Use extended regular expressions (supporting ?, +, {}, () and |):
grep -E ^regex$ path/to/file

# Print 3 lines of [C]ontext around, [B]efore, or [A]fter each match:
grep -C|B|A 3 search_string path/to/file

# Print the count of matches instead of the matching text:
grep -c search_string path/to/file

# Print line number for each match:
grep -n search_string path/to/file
```

With a file in place, write a function or a script to parse a command and
search the file. Here's a pretty naive one that takes two arguments: a command
name, and the number of lines to print after the command is spotted.

```bash
# Command for searching command-line-bullshit.txt
CMD_BS="$HOME/command-line-bullshit.txt"
function command_line_bullshit {
    cat "$CMD_BS" | grep -E -A $2 "^# $1"
}
alias clb="command_line_bullshit"
```

Running `clb grep 5` on my machine will produce --

```
# grep :: Used for matching regular expressions to files.
grep <flags> <regular expression> <filename>

# Use extended regular expressions (supporting ?, +, {}, () and |):
grep -E ^regex$ path/to/file
```

Of course, you need to have at least these five lines and the file must exist,
but you get the idea. There are many modifications you could make to this short
function. One that immediately comes to mind is to have the function open the
`less` program to the line which begins with `# [target-command]`, instead of
requiring you to supply the number of lines it will print as the second
argument.

