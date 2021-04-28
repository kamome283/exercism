defmodule WordCount do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """

  defp normalize(sentence) do
    sentence
    |> String.replace(~w/: ! & @ $ % ^ & ,/, "")
    |> String.replace("_", " ")
    |> String.downcase()
  end

  @spec count(String.t()) :: map
  def count(sentence) do
    sentence
    |> normalize()
    |> String.split()
    |> Enum.frequencies()
  end
end
